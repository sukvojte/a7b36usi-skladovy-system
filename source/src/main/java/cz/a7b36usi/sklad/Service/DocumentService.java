/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.a7b36usi.sklad.Service;

import cz.a7b36usi.sklad.BO.DocumentBO;
import cz.a7b36usi.sklad.BO.DocumentType;
import cz.a7b36usi.sklad.BO.MovementBO;
import cz.a7b36usi.sklad.BO.PartnerBO;
import cz.a7b36usi.sklad.BO.ProductBO;
import cz.a7b36usi.sklad.BO.ProductVersionBO;
import cz.a7b36usi.sklad.BO.WrappingTypeBO;
import cz.a7b36usi.sklad.DTO.DocumentDTO;
import cz.a7b36usi.sklad.DTO.MovementDTO;
import cz.a7b36usi.sklad.DTO.PartnerDTO;
import cz.a7b36usi.sklad.DTO.ProductDTO;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

/**
 *
 * @author Peter
 */
@Component
public class DocumentService extends AbstractService implements IDocumentService {

    public Long saveDocument(DocumentDTO document) {
        DocumentBO bo = new DocumentBO();
        bo.setDate(document.getDate());
        bo.setDocumentType(document.getDocumentType());
        bo.setId(document.getId());
        bo.setNumber(document.getNumber());
        bo.setPartner(genericDAO.loadById(document.getPartner().getId(), PartnerBO.class)); 
	//TODO: nemuze se nastavovat, pac partner je null - nemame to ve formulari
        return genericDAO.saveOrUpdate(bo).getId();
    }

    public Long saveMovement(MovementDTO movement) {
        MovementBO bo = new MovementBO();
        bo.setId(movement.getId());
        bo.setPrice(movement.getPrice());
	System.out.println("ukladam quantitu "+movement.getQuantity());
	bo.setQuantity(movement.getQuantity());
        bo.setDocument(genericDAO.loadById(movement.getDocument().getId(), DocumentBO.class));
        ProductBO pbo = genericDAO.loadById(movement.getProdukt().getId(), ProductBO.class);
        bo.setProdukt(pbo);
        //bo.setVersion(movement.getVersion() != null ? genericDAO.loadById(movement.getVersion(), ProductVersionBO.class) : null);
        //bo.setWrapping(movement.getWrapping() != null ? genericDAO.loadById(movement.getWrapping(), WrappingTypeBO.class) : null);
        return genericDAO.saveOrUpdate(bo).getId();
    }

    public void removeDocument(Long documentId) {
        genericDAO.removeById(documentId, DocumentBO.class);
    }

    public void removeMovement(Long movementId) {
        genericDAO.removeById(movementId, MovementBO.class);
    }

    public List<DocumentDTO> getAllDocuments() {
        List<DocumentDTO> dtos = new ArrayList<DocumentDTO>();
        List<DocumentBO> bos = genericDAO.getAll(DocumentBO.class);
        for (DocumentBO documentBO : bos) {
             PartnerBO pbo = documentBO.getPartner();
            PartnerDTO partner = new PartnerDTO(
                    pbo.getId(),
                    pbo.getIsDodavatel(),
                    pbo.getIsOdberatel(),
                    pbo.getUlice(),
                    pbo.getMesto(),
                    pbo.getSpolecnost(),
                    pbo.getPsc(),
                    pbo.getCisloPopisne());
            
            DocumentDTO dto = new DocumentDTO(
                    documentBO.getId(),
                    documentBO.getDocumentType(),
                    partner,
                    documentBO.getNumber(),
                    documentBO.getDate());
            dtos.add(dto);
        }
        return dtos;
    }

    public List<MovementDTO> getAllMovements() {
        List<MovementDTO> dtos = new ArrayList<MovementDTO>();
        List<MovementBO> bos = genericDAO.getAll(MovementBO.class);
        for (MovementBO movementBO : bos) {
            ProductBO pbo = movementBO.getProdukt();
            ProductDTO product = new ProductDTO(
                    pbo.getId(),
                    pbo.getName(),
                    pbo.getCode(),
                    pbo.getQuantity(),
                    (pbo.getCategory()!=null ?  pbo.getCategory().getId() : 0));

            MovementDTO dto = new MovementDTO(
                    movementBO.getId(),
                    movementBO.getPrice(),
		    (movementBO.getWrapping()!=null ?  movementBO.getWrapping().getId() : 0)
                    ,
                    (movementBO.getVersion()!=null ?  movementBO.getVersion().getId() : 0),
                    product,
                    getDocumentById(movementBO.getDocument().getId())
		    ,movementBO.getQuantity());
		    
            dtos.add(dto);
        }
        return dtos;
    }

    public List<MovementDTO> getAllDocumentsMovements(Long documentId) {
        List<MovementDTO> dtos = new ArrayList<MovementDTO>();
        List<MovementBO> bos = genericDAO.getByProperty("document", genericDAO.loadById(documentId, DocumentBO.class), MovementBO.class);
        for (MovementBO movementBO : bos) {
            ProductBO pbo = movementBO.getProdukt();
            ProductDTO product = new ProductDTO(
                    pbo.getId(),
                    pbo.getName(),
                    pbo.getCode(),
                    pbo.getQuantity(),
                    (pbo.getCategory()!=null ?  pbo.getCategory().getId() : 0));
            MovementDTO dto = new MovementDTO(
                    movementBO.getId(),
                    movementBO.getPrice(),
		    (movementBO.getWrapping()!=null ?  movementBO.getWrapping().getId() : 0)
                    ,
                    (movementBO.getVersion()!=null ?  movementBO.getVersion().getId() : 0),
                    product,
                    getDocumentById(movementBO.getDocument().getId())
		    ,movementBO.getQuantity());
            dtos.add(dto);
        }
        return dtos;
    }

    public List<DocumentDTO> getAllPartnersDocuments(Long partnerId) {
        List<DocumentDTO> dtos = new ArrayList<DocumentDTO>();
        List<DocumentBO> bos = genericDAO.getByProperty("partner", genericDAO.loadById(partnerId, PartnerBO.class), DocumentBO.class);
        for (DocumentBO documentBO : bos) {
            
             PartnerBO pbo = documentBO.getPartner();
            PartnerDTO partner = new PartnerDTO(
                    pbo.getId(),
                    pbo.getIsDodavatel(),
                    pbo.getIsOdberatel(),
                    pbo.getUlice(),
                    pbo.getMesto(),
                    pbo.getSpolecnost(),
                    pbo.getPsc(),
                    pbo.getCisloPopisne());
            DocumentDTO dto = new DocumentDTO(
                    documentBO.getId(),
                    documentBO.getDocumentType(),
                    partner,
                    documentBO.getNumber(),
                    documentBO.getDate());
            dtos.add(dto);
        }
        return dtos;
    }

    public List<MovementDTO> getAllProductsMovements(Long productId) {
        List<MovementDTO> dtos = new ArrayList<MovementDTO>();
        List<MovementBO> bos = genericDAO.getByProperty("product", genericDAO.loadById(productId, ProductBO.class), MovementBO.class);
        for (MovementBO movementBO : bos) {
            ProductBO pbo = movementBO.getProdukt();
            ProductDTO product = new ProductDTO(
                    pbo.getId(),
                    pbo.getName(),
                    pbo.getCode(),
                    pbo.getQuantity(),
                   (pbo.getCategory()!=null ?  pbo.getCategory().getId() : 0));

            MovementDTO dto = new MovementDTO(
                    movementBO.getId(),
                    movementBO.getPrice(),
                    null,
                    null,
                    product,
                    getDocumentById(movementBO.getDocument().getId()),
		    movementBO.getQuantity());
            dtos.add(dto);
        }
        return dtos;
    }

    public DocumentDTO getDocumentById(Long documentId) {
        DocumentBO document = genericDAO.getById(documentId, DocumentBO.class);
         PartnerBO pbo = document.getPartner();
            PartnerDTO partner = new PartnerDTO(
                    pbo.getId(),
                    pbo.getIsDodavatel(),
                    pbo.getIsOdberatel(),
                    pbo.getUlice(),
                    pbo.getMesto(),
                    pbo.getSpolecnost(),
                    pbo.getPsc(),
                    pbo.getCisloPopisne());
        
        return new DocumentDTO(document.getId(), document.getDocumentType(), partner, document.getNumber(),document.getDate()  );
    }

}
